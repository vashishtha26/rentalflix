package io.egen.rentalflix;

import org.junit.Test;

import junit.framework.Assert;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
	@Test
	public void testFindAll(){
		Movie m1= new Movie(1,"Batman",2008,"English");
		Movie m2= new Movie(1,"Superman",2010,"spanish");
		Movie m3= new Movie(1,"Hobbit",2012,"French");
	
			MovieService mv=new MovieService();
			mv.create(m1);
			mv.create(m2);
			mv.create(m3);
			int actual=mv.findAll().size();
			Assert.assertEquals(3,actual);
			
		
	}
	@Test
	public void testFindByName(){
		Movie m1= new Movie(1,"Batman",2008,"English");
		
		MovieService mv=new MovieService();
		mv.create(m1);
		
		boolean actual=mv.findByName("Bat").contains(m1);
		Assert.assertEquals(true, actual);
	}
	@Test
	public void testCreate(){
		Movie m2= new Movie(1,"Superman",2010,"spanish");
		MovieService mv=new MovieService();
		String actual=mv.create(m2).getTitle();
		Assert.assertEquals("Superman", actual);
	}
	@Test
	public void testUpdate(){
		Movie m2= new Movie(0,"Superman",2010,"spanish");
		MovieService mv=new MovieService();
		mv.create(m2);
		m2.setTitle("SuperHero");
		String actual=mv.update(m2).getTitle();
		Assert.assertEquals("SuperHero", actual);
	}
	@Test
	public void testDelete(){
		Movie m1= new Movie(0,"Batman",2008,"English");
		Movie m2= new Movie(1,"Superman",2010,"spanish");
		MovieService mv=new MovieService();
		mv.create(m1);
		mv.create(m2);
		int actual=mv.delete(1).getId();
		Assert.assertEquals(1, actual);
		
	}
	@Test
	public void testRentMovie1(){
		Movie m1= new Movie(0,"Batman",2008,"English");
		Movie m2= new Movie(1,"Superman",2010,"spanish");
		MovieService mv=new MovieService();
		mv.create(m1);
		mv.create(m2);
		boolean actual= mv.rentMovie(0, "Vashishtha");
		Assert.assertEquals(true, actual);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testRentMovie2(){
		Movie m1= new Movie(0,"Batman",2008,"English");
		Movie m2= new Movie(1,"Superman",2010,"spanish");
		MovieService mv=new MovieService();
		mv.create(m1);
		mv.create(m2);
		boolean d= mv.rentMovie(0, "Vashishtha");
		boolean actual= mv.rentMovie(0, "Vashishtha");
	}
}
