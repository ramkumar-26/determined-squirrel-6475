package com.crimetime.dao;

import com.crimetime.exception.PoliceException;
import com.crimetime.model.Police;

public interface PoliceUserDao {
	public int registerNewPolice(Police police) throws PoliceException;
	public boolean policeLogin(int policeID,String password) throws PoliceException;
}
