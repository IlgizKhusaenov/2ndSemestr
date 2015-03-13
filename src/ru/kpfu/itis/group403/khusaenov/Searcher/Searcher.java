package ru.kpfu.itis.group403.khusaenov.Searcher;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.io.FileFilter;

public class Searcher {
    private String[] args = null;
    private Options options = new Options();

    public Searcher(String[] args) {

        this.args = args;

        options.addOption("h", "help", false, "Справка.");
        options.addOption("r", false, "Рекурсивный поиск.");
        options.addOption("d", true, "Степень вложенности.");
        options.addOption("v", false, "Показать папки с искомым именем.");

    }

    public void run() {
        CommandLineParser parser = new BasicParser();

        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("h"))
                help();
            else if (cmd.hasOption("r") && cmd.hasOption("d"))
                throw new IllegalArgumentException("Параметры \"r\" и \"d\" не могут быть использованы вместе");
            else {
                String[] args = cmd.getArgs();
                if (args.length != 2)
                    throw new IllegalArgumentException("Передано неверное количество аргументов");
                else {
                    if (cmd.hasOption("d"))
                        search(Integer.parseInt(cmd.getOptionValue("d")), cmd.hasOption("v"), args[0], args[1]);
                    else search((cmd.hasOption("r") ? null : 1), cmd.hasOption("v"), args[0], args[1]);
                }
            }


        } catch (ParseException e) {
            help();
        }
    }

    public void search(Integer depth, boolean showFolders, String folderName, String fileMask) {
        File folder = new File(folderName);
        if (!folder.isDirectory() || !folder.exists()) throw new IllegalArgumentException("Директории с таким именем не существует");
        search(folder, showFolders, new WildcardFileFilter("*" + fileMask + "*"), depth);
    }

    private void search(File folder, boolean showFolders, FileFilter filter, Integer leftDepth){
        File[] foundContents = folder.listFiles(filter);
        File[] folders = folder.listFiles((FileFilter) DirectoryFileFilter.INSTANCE);
        for(File file : foundContents) {
            if((file.isDirectory() && showFolders) || !file.isDirectory()) {
                System.out.println(file.getPath());
            }
        }

        for(File f : folders) {
            if(leftDepth == null || leftDepth > 1) {
                search(f, showFolders, filter, leftDepth == null ? null : leftDepth - 1);
            }
        }

    }

    private void help() {
        HelpFormatter formatter = new HelpFormatter();

        formatter.printHelp("[опции] директорияПоиска имяФайла.", options);
        System.exit(0);
    }
}