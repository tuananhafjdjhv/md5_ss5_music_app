package ra.spring_mvc_music_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.spring_mvc_music_app.model.entity.Music;
import ra.spring_mvc_music_app.model.service.IMusicService;
import ra.spring_mvc_music_app.model.service.MusicService;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private IMusicService musicService;
    @GetMapping("/")
    public String home(Model model){
        List<Music> list = musicService.findAll();
        model.addAttribute("list",list);
        return "Home";
    }
}
