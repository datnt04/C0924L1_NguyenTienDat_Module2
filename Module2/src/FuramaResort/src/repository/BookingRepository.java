    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package repository;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Comparator;
    import java.util.TreeSet;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import model.Booking;

    /**
     *
     * @author ACER
     */
    public class BookingRepository implements IBookingRepository {
        private static final String BOOKING_FILE_PATH = "src/data/Booking.csv";
         private static TreeSet<Booking> bookings = new TreeSet<>(new BookingComparator());
    private FacilityRepository facilityRepository = new FacilityRepository(); 

     @Override
    public TreeSet<Booking> readFile() {
        bookings.clear(); 
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKING_FILE_PATH))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    Booking booking = new Booking(
                        data[0],
                        dateFormat.parse(data[1]),
                        dateFormat.parse(data[2]),
                        dateFormat.parse(data[3]),
                        data[4],
                        data[5]
                    );
                    bookings.add(booking);
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading booking file: " + e.getMessage());
        }
        return bookings;
    }

    @Override
    public void writeFile(TreeSet<Booking> entities) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKING_FILE_PATH))) { 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Booking booking : entities) {
            writer.write(String.join(",",
                booking.getBookingId(),
                sdf.format(booking.getBookingDate()),
                sdf.format(booking.getStartDate()),
                sdf.format(booking.getEndDate()),
                booking.getCustomerId(),
                booking.getServiceCode()
            ));
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error writing booking file: " + e.getMessage());
    }
}
    @Override
    public void addBooking(Booking booking) {
        bookings.add(booking);
    writeFile(bookings); 
    incrementUsage(booking.getServiceCode());
}
    private void incrementUsage(String serviceCode) {
        facilityRepository.incrementUsage(serviceCode);
    }

    @Override
    public TreeSet<Booking> getAllBookings() {
        return bookings;
    }
}
