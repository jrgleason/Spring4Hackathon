package com.gleason.itext.controllers

import com.lowagie.text.Document
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfWriter
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created with IntelliJ IDEA.
 * User: jgleason
 * Date: 6/18/14
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/groovy/**")
class Chapter1 {
    @RequestMapping("/test1")
    def test1(){
        Document document = new Document()
        File file = new File("results")
        file.mkdirs()
        PdfWriter.getInstance(document, new FileOutputStream("results/test1.pdf"))
        document.open()
        document.add(new Paragraph("This is a test!"))
        document.close()
        return "redirect:/";
    }
    @RequestMapping("/")
    def index(){
        "Welcome To the dark Side";
    }
}
