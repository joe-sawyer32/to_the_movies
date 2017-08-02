package com.theironyard.to_the_movies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
    public String nowPlaying() {
        return "now-playing";
    }

    @RequestMapping(path = "/medium-popular-long-name", method = RequestMethod.GET)
    public String mediumPopularLongName() {
        return "medium-popular-long-name";
    }
}
