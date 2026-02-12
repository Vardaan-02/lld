package Structural.Composite;

import Structural.Composite.fileSystem.impl.File;
import Structural.Composite.fileSystem.impl.Folder;

public class Main {
    public static void main(String args[]){
        Folder root = new Folder("root");

        // ---- system folder ----
        Folder system = new Folder("system");
        system.add(new File("kernel.sys", 5000));
        system.add(new File("config.cfg", 200));

        Folder drivers = new Folder("drivers");
        drivers.add(new File("audio.drv", 800));
        drivers.add(new File("video.drv", 1200));

        system.add(drivers);

        // ---- users folder ----
        Folder users = new Folder("users");

        Folder vardaan = new Folder("vardaan");
        vardaan.add(new File("resume.pdf", 300));
        vardaan.add(new File("notes.txt", 50));

        Folder projects = new Folder("projects");
        projects.add(new File("project1.zip", 2000));
        projects.add(new File("project2.zip", 3500));

        vardaan.add(projects);

        Folder downloads = new Folder("downloads");
        downloads.add(new File("movie.mkv", 7000));
        downloads.add(new File("setup.exe", 1500));

        vardaan.add(downloads);

        users.add(vardaan);

        // ---- logs folder ----
        Folder logs = new Folder("logs");
        logs.add(new File("app.log", 400));
        logs.add(new File("error.log", 600));

        // ---- assemble root ----
        root.add(system);
        root.add(users);
        root.add(logs);

        // ---- operations ----
        root.print();
        System.out.println("\nTotal filesystem size: " + root.getSize());
    }
}
