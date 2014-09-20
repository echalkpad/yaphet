package org.darion.channel;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelExamples {
  public static void main(String[] args) throws IOException {
    FileChannel channel = FileChannel.open(Paths.get("/tmp/file"), StandardOpenOption.READ);
  }
}
