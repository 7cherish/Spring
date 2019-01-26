package com.kh.spring.demo.model.service;

import java.util.List;

import com.kh.spring.demo.model.vo.Dev;

public interface DemoService {

	int insertDev(Dev dev);

	List<Dev> selectDemoList();

<<<<<<< HEAD
	int deleteDev(String no);
=======
	void deleteDev();
>>>>>>> 8329c54fb4bea34ecdff0fe34dabe928e0ebf8c2

}
