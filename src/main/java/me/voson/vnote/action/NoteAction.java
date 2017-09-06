package me.voson.vnote.action;

import me.voson.vnote.dao.NoteDao;
import me.voson.vnote.entity.Note;
import me.voson.vnote.service.NoteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class NoteAction {
    @Resource
    private NoteDao noteDao;

    @Resource
    private NoteService noteService;

    /*按照id获取笔记内容*/
    @RequestMapping(value="/notes/{shortId}", method = RequestMethod.GET)
    public Note getNote(@PathVariable Short shortId){
        return noteDao.findByShortID(shortId);
    }

    /*保存一条笔记，可能是新笔记也可能是已有笔记*/
    @RequestMapping(value="/notes", method = RequestMethod.POST)
    public Object save(String note,Short shortId){
        return noteService.save(note,shortId);
    }

    /*获取所有的笔记列表*/
    @RequestMapping(value="/notes", method = RequestMethod.GET)
    public List<Note> getNotes(){return noteDao.findAll();}

    /*按照id删除一条笔记*/
    @RequestMapping(value="/notes/{shortId}", method = RequestMethod.DELETE)
    public Integer deleteNote(@PathVariable Short shortId){
        return noteDao.remove(shortId);
    }

    /*批量删除笔记*/
    @RequestMapping(value="/notes", method = RequestMethod.DELETE)
    public Integer deleteNotes(@RequestBody ArrayList<String>  notes){
        return noteDao.deleteNotes(notes);
    }

    /**
     *
     * @return 一个小于9999，在数据库中不重复的short数字
     */
    @RequestMapping(value="/shortids", method = RequestMethod.POST)
    public Short getShortId(){
        Short a;
        do{
            a=(short)new Random().nextInt(9999);
        }while (noteDao.findAllShortId().contains(a));
        return a;
    }
}
