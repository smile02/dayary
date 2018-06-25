package com.inc.dayary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inc.dayary.domain.Diary;
import com.inc.dayary.domain.Tag;
import com.inc.dayary.repository.DiaryDao;
import com.inc.dayary.repository.TagDao;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDao diaryDao;
	
	@Autowired
	private TagDao tagDao;
	
	@Override
	public List<Diary> list() {
		return diaryDao.list();
	}

	@Override
	@Transactional
	public void add(Diary diary) {
		diaryDao.add(diary); //현재 아이디는 시퀀스로 넣기 때문에 여기서는 0임		
		
		if(diary.getTags() != null) {
			int d_id = diary.getId(); //mapper에서 selectKey태그 안에 사용한 현재의 시퀀스 값을 가져옴
			for(Tag tag : diary.getTags()) {			
				tag.setD_id(d_id);
				tagDao.add(tag);
			}
		}
	}

	@Override
	public List<Diary> list(String id) {		
		return diaryDao.list(id);
	}

}
