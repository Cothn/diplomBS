package org.atsynthesizer.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("synthesizer")
public class SynthesizerController {

    @GetMapping("")
    public String getSynthesizerPage() {

        return "synthesizerPage";
    }
}
