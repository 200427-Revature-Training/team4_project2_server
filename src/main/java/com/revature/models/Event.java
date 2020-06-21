package com.revature.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String image;
	private double price;
	
	@Column(name = "start_time")
	private LocalDate startTime;
	
	@Column(name = "max_people")
	private int maxPeople;
	
	private String description;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_type_id")
	private EventType eventType;
	
	// The many side loads lazily by default
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "event_id")
	private List<Post> posts;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "host_id")
	private User user;
		
	@ManyToMany
	@JoinTable(name="user_events", joinColumns = { @JoinColumn(name="event_id") },
							inverseJoinColumns = { @JoinColumn(name="user_id")})
	private List<User> users;

	@ManyToMany
	@JoinTable(name="user_events", joinColumns = { @JoinColumn(name="user_id") },
							inverseJoinColumns = { @JoinColumn(name="event_id")})
	private List<Event> events;

}
