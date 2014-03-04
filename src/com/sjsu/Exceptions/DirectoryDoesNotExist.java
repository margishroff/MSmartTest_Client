package com.sjsu.Exceptions;


import java.io.Serializable;


public class DirectoryDoesNotExist extends Exception implements Serializable
{

    private static final long serialVersionUID = 1L;
    public DirectoryDoesNotExist()
    {
            
    }
    public String toString()
    {
            return "Directory Does not exist!";
            //return value 10
    }

}