package com.haurui.java175.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AdsController {
  @Value("${ads.image.base.path}")
  private String basePath;

  @RequestMapping("/")
  public String index(ModelMap map){
    File dir = new File(basePath);
    File[] files = dir.listFiles();
    map.put("adsList", files);
    return "index";
  }

  @PostMapping("/upload-ads")
  public String uploadAds(MultipartFile[] files) throws IOException {
    for (MultipartFile file : files) {
      String extension = FilenameUtils.getExtension(file.getOriginalFilename());
      String filename = String.format("%s.%s", UUID.randomUUID(), extension);
      File dest = new File(basePath, filename); //D:/images/1234567890ADFASD.jpg
      FileUtils.forceMkdirParent(dest);
      file.transferTo(dest);
    }
    return "redirect:/";
  }
}
