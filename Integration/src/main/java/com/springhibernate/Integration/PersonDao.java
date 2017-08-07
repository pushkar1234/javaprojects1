package com.springhibernate.Integration;

import java.util.List;

public interface PersonDao {
	public void save(Person p);
	public List<Person> list();
	public void update();
	public void delete();
    
}
