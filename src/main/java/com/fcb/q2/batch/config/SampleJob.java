package com.fcb.q2.batch.config;

import java.io.File;
import java.util.List;

import com.fcb.q2.batch.entity.Student;
import com.fcb.q2.batch.processor.FirstItemProcessor;
import com.fcb.q2.batch.reader.FirstItemReader;
import com.fcb.q2.batch.repository.JpaRepoWriter;
import com.fcb.q2.batch.repository.StudentRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;


@Configuration
public class SampleJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private FirstItemReader firstItemReader;
	
	@Autowired
	private FirstItemProcessor firstItemProcessor;
	
	/*Autowired
	private FirstItemWriter firstItemWriter;*/

	@Autowired
	private JpaRepoWriter jpaRepoWriter;

	@Autowired
	private StudentRepository studentRepository	;



	@Bean
	public Job chunkJob() {
		return jobBuilderFactory.get("Chunk Job")
				.incrementer(new RunIdIncrementer())
				.start(firstChunkStep())
				.build();
	}
	
	private Step firstChunkStep() {
		return stepBuilderFactory.get("First Chunk Step")
				.<Student, Student>chunk(4)
				.reader(flatFileItemReader())
				//.processor(firstItemProcessor)
				.writer(studentWriter())
				.build();
	}
	
	public FlatFileItemReader<Student> flatFileItemReader() {
		FlatFileItemReader<Student> flatFileItemReader =
				new FlatFileItemReader<Student>();
		
		flatFileItemReader.setResource(new FileSystemResource(
				new File("C:\\Users\\gain\\git\\fcb_q2_batch\\InputFiles\\students.csv")));


		flatFileItemReader.setLinesToSkip(1);
//		flatFileItemReader.setResource(new ClassPathResource("/data/customer.csv"));

		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//		tokenizer.setNames(new String[] {"id", "firstName", "lastName", "birthdate"});
		tokenizer.setNames(new String[] {"ID", "First Name", "Last Name", "Email"});

		DefaultLineMapper<Student> customerLineMapper = new DefaultLineMapper<>();
		customerLineMapper.setLineTokenizer(tokenizer);
//		customerLineMapper.setFieldSetMapper(new CustomerFieldSetMapper());
	    		customerLineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {
			{
				setTargetType(Student.class);
			}
		});

		customerLineMapper.afterPropertiesSet();

		flatFileItemReader.setLineMapper(customerLineMapper);
		/*flatFileItemReader.setLineMapper(new DefaultLineMapper<Student>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames("ID", "First Name", "Last Name", "Email");
					}
				});
				
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {
					{
						setTargetType(Student.class);
					}
				});
				
			}
		});
		
		flatFileItemReader.setLinesToSkip(1);*/
		
		return flatFileItemReader;
	}

	//Writer class Object
	@Bean
	public ItemWriter<Student> studentWriter(){
		// return new InvoiceItemWriter(); // Using lambda expression code instead of a separate implementation
		return students -> {
			System.out.println("Saving students Records: " );
			// stream and print each invoice record
           students.forEach(System.out::println);

			studentRepository.saveAll(students);
		};
	}

}
