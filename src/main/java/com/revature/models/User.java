package com.revature.models;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "first_name")
	private double firstName;
	
	@Column(name = "last_name")
	private double lastName;
	private double email;
	
	// The many side loads lazily by default
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "host_id")
	private List<Event> host_events;
		
	// The many side loads lazily by default
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private List<Post> posts;
		
	// The many side loads lazily by default
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private List<Comment> comments;

//	@ManyToMany
//	@JoinTable(name="user_events", joinColumns = { @JoinColumn(name="user_id") },
//							inverseJoinColumns = { @JoinColumn(name="event_id")})
//	private List<Event> events;
//
//	@ManyToMany
//	@JoinTable(name="user_events", joinColumns = { @JoinColumn(name="event_id") },
//							inverseJoinColumns = { @JoinColumn(name="user_id")})
//	private List<User> users;

}
