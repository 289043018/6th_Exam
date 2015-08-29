package com.hand.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class Logging {
   /** Following is the definition for a pointcut to select
    *  all the methods available. So advice will be called
    *  for all the methods.
    */
	 @Pointcut("execution(* com.hand.film.FilmJDBCTemplate.create(..))")
   private void selectAll(){}
   /** 
    * This is the method which I would like to execute
    * before a selected method execution.
    */
	 @After("selectAll()")
   public void BeforeInsertFilmEvent(){
      System.out.println("Before	 Insert	 Film	Data.");
   }
   /** 
    * This is the method which I would like to execute
    * after a selected method execution.
    */
	 @After("selectAll()")
   public void AfterInsertFilmEvent(){
      System.out.println("After	Insert	Film	Data.");
   }
   /** 
    * This is the method which I would like to execute
    * when any method returns.
    */

   public void afterReturningAdvice(Object retVal){
      System.out.println("Returning:" + retVal.toString() );
   }
   /**
    * This is the method which I would like to execute
    * if there is an exception raised by any method.
    */

   public void AfterThrowingAdvice(IllegalArgumentException ex){
      System.out.println("There has been an exception: " + ex.toString());   
   }  
}