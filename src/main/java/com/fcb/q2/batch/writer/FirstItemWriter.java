package com.fcb.q2.batch.writer;

import java.util.List;

import com.fcb.q2.batch.entity.Student;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;


@Component
public class FirstItemWriter implements ItemWriter<Student> {

	@Override
	public void write(List<? extends Student> items) throws Exception {
		System.out.println("Inside Item Writer");
		items.stream().forEach(System.out::println);
	}

}
