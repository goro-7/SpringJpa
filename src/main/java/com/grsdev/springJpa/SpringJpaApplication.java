package com.grsdev.springJpa;

import static java.lang.System.out;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class SpringJpaApplication {
	
	@PersistenceContext
	private EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(TopicRepository topicRepo) {
		
		CommandLineRunner clr = null;
	
		clr = (a)->{
			
			topicRepo.save(new Topic("java", "java", "description",1.2D));
			
			out.println(topicRepo.findAll());
		};
		
		return clr;
	}
}

@Entity
class Topic{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@Column(length=100)
	private String code;
	
	@Column(insertable=false)
	private String description;
	
	@Column(precision=2,scale=2)
	private double price;
	
	public Topic() {
		super();
	}
	public Topic(String name, String code,String description,double price) {
		this.name = name;
		this.code = code;
		this.description=description;
		this.price=price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description + ", price="
				+ price + "]";
	}
	
}


interface TopicRepository extends JpaRepository<Topic, Long>{
	
}

@Entity
class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String code;
	
	private String name;
	
	private float fee;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false,name="topic_id")
	private Topic topic;
	
	

	public Course(String code, String name, float fee, Topic topic) {
		super();
		this.code = code;
		this.name = name;
		this.fee = fee;
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", code=" + code + ", name=" + name + ", fee=" + fee + ", topic=" + topic + "]";
	}
	
}
