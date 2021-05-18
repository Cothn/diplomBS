package org.atsynthesizer.demo.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.atsynthesizer.demo.entity.Audiobook;
import org.atsynthesizer.demo.entity.AudiobookFile;
import org.atsynthesizer.demo.entity.Creator;
import org.atsynthesizer.demo.entity.User;
import org.atsynthesizer.demo.service.AudiobookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("synthesizer")
public class SynthesizerController {

    @Value("${upload.path}")
    private String UPLOAD_DIR;

    @Value("${upload.win.path}")
    private String UPLOAD_PATH;

    private static final String[] voices= new String[]{
            "Anna",
            "Aleksandr",
            "Arina",
            "Elena",
            "Evgeniy",
            "Irina",
            "Pavel",
            "Victoria"};


    @GetMapping("")
    public String getSynthesizerPage(
            @RequestParam(defaultValue = "Aleksandr") String voiceOld,
            @RequestParam(defaultValue = "0") int speed,
            @RequestParam(defaultValue = "0") int height,
            @AuthenticationPrincipal UserDetails currentUser,
            Model model) throws IOException {

        model.addAttribute("voiceOld", voiceOld);
        model.addAttribute("speed", speed);
        model.addAttribute("voices", voices);
        model.addAttribute("height", height);
        model.addAttribute("text", "Этот текст можно заменить любым текстом по вашему желанию.\n" +
                        "В этом текстовом поле можно ввести или вставить собственный текст.\n" +
                        "Вы можете изменить голос диктора, а также высоту голоса и скорость речи.");

        return "synthesizerPage";
    }

    @PostMapping("/test")
    public String testVoice(
            @RequestParam(defaultValue = "Aleksandr") String voiceOld,
            @RequestParam(defaultValue = "0") int speed,
            @RequestParam(defaultValue = "0") int height,
            @RequestParam(required = true) String text,
            @AuthenticationPrincipal UserDetails currentUser,
            Model model) throws IOException {

        String command = "D:\\repositHub\\diplomBS\\src\\main\\util\\balcon" +
                " -n \"RHVoice " + voiceOld + "\"" +
                " -s " + speed +
                " -p " + height +
                " -enc utf-8" +
                " --voice1-name Zira --voice1-langid en" +
                " -t " + "\""+text+"\"" +
                " -o --raw" +
                " | D:\\repositHub\\diplomBS\\src\\main\\util\\lame -r -s 22.05 -m m -h "+
                " - "+UPLOAD_PATH+currentUser.getUsername()+"\\test.mp3";
        command = command.replace("\n", " ");
        command = command.replace("\r", "");

        Process pr=Runtime.getRuntime().exec(new String[]{"cmd.exe","/c", command});

        model.addAttribute("voiceOld", voiceOld);
        model.addAttribute("voices", voices);
        model.addAttribute("speed", speed);
        model.addAttribute("height", height);
        model.addAttribute("text", text);
        model.addAttribute("testFilePath", "/"+currentUser.getUsername()+"/test.mp3");

        return "synthesizerPage";
    }

    @PostMapping("/getAudiobook")
    public String getAudiobookFile(
            @RequestParam(defaultValue = "Aleksandr") int voiceOld,
            @RequestParam(defaultValue = "0") int speed,
            @RequestParam(defaultValue = "0") int height,
            @RequestParam(required = true) MultipartFile bookFileStream,
            @AuthenticationPrincipal UserDetails currentUser,
            Model model) throws IOException {

        if((!bookFileStream.isEmpty()) && (bookFileStream.getSize() != 0))  {
            if (this.saveBookFile(bookFileStream, currentUser).isEmpty()) {
                return "redirect:/audiobooks/add";
            }
        }

        String command = "D:\\repositHub\\diplomBS\\src\\main\\util\\balcon" +
                " -n \"RHVoice " + voiceOld + "\"" +
                " -s " + speed +
                " -p " + height +
                " -enc utf-8" +
                " --voice1-name Zira --voice1-langid en" +
                " -f "+UPLOAD_PATH+currentUser.getUsername()+"\\book.txt" +
                " -o --raw" +
                " | D:\\repositHub\\diplomBS\\src\\main\\util\\lame -r -s 22.05 -m m -h"+
                " - "+UPLOAD_PATH+currentUser.getUsername()+"\\audiobook.mp3";
        command = command.replace("\n", " ");
        command = command.replace("\r", "");

        Process pr=Runtime.getRuntime().exec(new String[]{"cmd.exe","/c", command});

        model.addAttribute("voiceOld", voiceOld);
        model.addAttribute("voices", voices);
        model.addAttribute("speed", speed);
        model.addAttribute("height", height);
        model.addAttribute("audiobookFilePath", "/"+currentUser.getUsername()+"/audiobook.mp3");
        model.addAttribute("text", "Этот текст можно заменить любым текстом по вашему желанию.\n" +
                "В этом текстовом поле можно ввести или вставить собственный текст.\n" +
                "Вы можете изменить голос диктора, а также скорость и высоту тона речи."
                +"\nLondon is the capital of Brittan."
        );

        return "synthesizerPage";
    }

    private String saveBookFile(MultipartFile file, UserDetails currentUser) throws IOException {

        // Make sure directory exists!
        File uploadDir = new File(UPLOAD_DIR +currentUser.getUsername());
        if(!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        if (!file.isEmpty()) {
            String uploadFilePath = currentUser.getUsername() + "/book.txt";

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + uploadFilePath);
            Files.deleteIfExists(path);
            Files.write(path, bytes);
            return uploadFilePath;
        } else {
            return "";
        }

    }

}
