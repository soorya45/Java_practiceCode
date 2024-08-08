import java.util.Random;

class Frame {
    int sequenceNumber;
    String data;

    public Frame(int sequenceNumber, String data) {
        this.sequenceNumber = sequenceNumber;
        this.data = data;
    }
}

public class eee {
    static final int WINDOW_SIZE = 4;
    static final int FRAME_COUNT = 10;

    public static void main(String[] args) {
        // Simulating a communication channel
        Random random = new Random();

        Frame[] senderFrames = new Frame[FRAME_COUNT];
        Frame[] receiverFrames = new Frame[FRAME_COUNT];

        for (int i = 0; i < FRAME_COUNT; i++) {
            senderFrames[i] = new Frame(i, "Data of Frame " + i);
            receiverFrames[i] = null;
        }

        int senderBase = 0;
        int receiverBase = 0;

        while (receiverBase < FRAME_COUNT) {
            // Sender transmits frames within the window
            for (int i = senderBase; i < Math.min(senderBase + WINDOW_SIZE, FRAME_COUNT); i++) {
                if (senderFrames[i] != null) {
                    if (random.nextDouble() < 0.2) {
                        // Simulate frame loss
                        System.out.println("Frame " + i + " lost.");
                    } else {
                        // Simulate successful transmission
                        System.out.println("Frame " + i + " sent.");
                    }
                }
            }

            // Receiver receives frames within the window
            for (int i = receiverBase; i < Math.min(receiverBase + WINDOW_SIZE, FRAME_COUNT); i++) {
                if (receiverFrames[i] == null) {
                    if (random.nextDouble() < 0.1) {
                        // Simulate frame corruption
                        System.out.println("Frame " + i + " corrupted.");
                    } else {
                        // Simulate successful reception
                        receiverFrames[i] = senderFrames[i];
                        System.out.println("Frame " + i + " received.");
                    }
                }
            }

            // Slide the window
            while (receiverBase < FRAME_COUNT && receiverFrames[receiverBase] != null) {
                System.out.println("Acknowledgment for Frame " + receiverBase + " sent.");
                receiverBase++;
            }

            senderBase = receiverBase;
        }

        System.out.println("All frames have been successfully transmitted and acknowledged.");
    }
}
