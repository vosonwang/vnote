package me.voson.vnote.service;

import me.voson.vnote.dao.NoteDao;
import me.voson.vnote.entity.Note;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("noteService")
public class NoteService {
    @Resource
    private NoteDao noteDao;

    public Object save(String note, Short shortId){
        Note record=noteDao.findByShortID(shortId);
        if(record==null){
            /*查无此id，新建,返回note对象或null*/
            return noteDao.save(new Note(note,shortId));
        }else {
            /*有此ID，update，返回Integer，0或1*/
            return noteDao.update(shortId,note);
        }
    }
}
