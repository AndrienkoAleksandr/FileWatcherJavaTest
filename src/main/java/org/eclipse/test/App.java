package org.eclipse.test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.*;

// https://docs.oracle.com/javase/tutorial/essential/io/notification.html
public class App {
    public static void main( String[] args ) {
        Path dir = Paths.get("/home/user/IdeaProjects /FileWatcherJavaTest/src/test/java/org/eclipse/test");

        try {

            WatchService watcher = FileSystems.getDefault().newWatchService(); // "todo mount problem here?"

            WatchKey key = dir.register(watcher,
                                        ENTRY_CREATE,
                                        ENTRY_DELETE,
                                        ENTRY_MODIFY);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
