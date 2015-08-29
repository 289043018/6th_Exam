package com.hand.film;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class FilmJDBCTemplate implements FilmDao {

	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject; 
	   private PlatformTransactionManager transactionManager;
	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }
	   
	   public void setTransactionManager(
			      PlatformTransactionManager transactionManager) {
			      this.transactionManager = transactionManager;
			   }

	public void create(String title,String description, Long language_id) {
		 TransactionDefinition def = new DefaultTransactionDefinition();
	      TransactionStatus status = transactionManager.getTransaction(def);
	      try {
	    	String SQL ="INSERT INTO film (title  ,description , language_id ) values (?,?,?)";
	    	jdbcTemplateObject.update( SQL, title, description,language_id);
	    	transactionManager.commit(status);
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
	         transactionManager.rollback(status);
	         throw e;
		}
	      
	    return;  
	}

	public FilmEntity getStudent(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FilmEntity> listStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub

	}

	public void printThrowException() {
		System.out.println("Exception raised");
	       throw new IllegalArgumentException();
		
	}

}
