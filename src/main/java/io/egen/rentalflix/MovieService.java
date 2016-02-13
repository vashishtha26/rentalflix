package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	
	List<Movie> movies= new ArrayList<Movie>();
	
	@Override
	public List<Movie> findAll() {
		return movies;
	}
	
	
	@Override
	public List<Movie> findByName(String name) {
		List<Movie> mList=new ArrayList<Movie>();
		for(Movie m: movies){
			if(m.getTitle().contains(name)){
				mList.add(m);
			}
		}
		return mList;
	}
	
	
	@Override
	public Movie create(Movie movie) {
		movies.add(movie);
		return movie;
	}
	
	@Override
	public Movie update(Movie movie) {
		boolean mGet=movies.contains(movie);
		if(!mGet){
			throw new IllegalArgumentException("Error for Update");
		}
		movies.set(movie.getId(), movie);
		return movie;
	}
	
	
	@Override
	public Movie delete(int id) {
		Movie m=movies.get(id);
		if(m == null){
			throw new IllegalArgumentException("Error for Delete");
		}
		movies.remove(m);
		return m;
	}
	
	@Override
	public boolean rentMovie(int movieId, String user) {
	   	Movie m=movies.get(movieId);
		if(m.isRent()){
			throw new IllegalArgumentException("Error renting");
		}
		m.setRent(true);
		return true;
	}
	
}

