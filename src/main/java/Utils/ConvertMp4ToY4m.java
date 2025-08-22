package Utils;

public class ConvertMp4ToY4m {
    public void convertMp4ToY4m(String mp4Path, String y4mPath) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "ffmpeg",
                    "-y",                 // overwrite if exists
                    "-i", mp4Path,
                    "-pix_fmt", "yuv420p",
                    y4mPath
            );
            pb.inheritIO(); // optional: show ffmpeg output in console
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to convert mp4 to y4m");
        }
    }

}
