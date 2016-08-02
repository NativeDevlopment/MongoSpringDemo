package com.test.dao;

import com.test.exception.SequenceException;

public interface SequenceDao {
	long getNextSequenceId(String key) throws SequenceException;
}
