package ru.kpfu.itis.group403.khusaenov.Deadlock;


public class Deadlock {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format(this.name + ": " + bower.getName() + " has bowed to me!\n");
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.print(this.name + ": " + bower.getName() + " has bowed back to me!\n");
        }
    }

    public static void main(String[] args) {
        final Friend ronald = new Friend("Ronald");
        final Friend harry = new Friend("Harry");
        new Thread(new Runnable() {
            public void run() {
                ronald.bow(harry);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                harry.bow(ronald);
            }
        }).start();
    }
}