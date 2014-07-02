package com.gleason.itext.controllers;

import com.google.gson.Gson;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/java/**")
public class JavaController {
    @RequestMapping("/")
    public String test(){
      System.out.println("Test");
      return "Do or do not, there is no try!";
    }
    @RequestMapping("/audio")
    public String getLines(){
        Gson g = new Gson();
        StringBuilder builder = new StringBuilder();
        Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
        for (Mixer.Info info : mixerInfos) {
            System.out.println("Mixer is "+ g.toJson(info)+String.format("%n"));
            Mixer m = AudioSystem.getMixer(info);
            Line.Info[] lineInfos = m.getSourceLineInfo();
            System.out.println(String.format("Source Lines%n"));
            for (Line.Info lineInfo : lineInfos) {
                System.out.println(lineInfo+String.format("%n"));
                builder.append(info.getName() + "---" + lineInfo+String.format("%n"));
                try {
                    Line line = m.getLine(lineInfo);
                    builder.append("\t-----" + line+String.format("%n"));
                } catch (LineUnavailableException ex) {
                    // Handle the error ...
                }
            }
            System.out.println(String.format("Target Lines%n"));
            lineInfos = m.getTargetLineInfo();
            for (Line.Info lineInfo : lineInfos) {
                System.out.println(lineInfo+String.format("%n"));
                builder.append(m + "---" + lineInfo+String.format("%n"));
                try {
                    Line line = m.getLine(lineInfo);
                    builder.append("\t-----" + line+String.format("%n"));
                } catch (LineUnavailableException ex) {
                    // Handle the error ...
                }
            }
        }
        return builder.toString();
    }

    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

    @RequestMapping("/capture")
    public String capture(){
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format =  new AudioFormat(sampleRate,
                sampleSizeInBits, channels, signed, bigEndian);
        DataLine.Info info = new DataLine.Info(
                TargetDataLine.class, format);
        // checks if system supports the data line
        if (!AudioSystem.isLineSupported(info)) {
            System.out.println("Line not supported");
            return "Error!";
        }
        try{
            TargetDataLine line = (TargetDataLine)
                    AudioSystem.getLine(info);
            line.open(format);
            line.start();
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            File wavFile = new File("C:/RecordAudio.wav");
            AudioInputStream ais = new AudioInputStream(line);
            AudioSystem.write(ais, fileType, wavFile);
            while (stopWatch.getLastTaskTimeMillis()<10000) {
                 //Just Chill.....
            }
            stopWatch.stop();
            line.stop();
            line.close();
        }
        catch(IOException ioe){

        }
        catch(LineUnavailableException le){

        }

        return "Done!";
    }
}
