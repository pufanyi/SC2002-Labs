import java.util.Arrays;
import java.util.Comparator;

public class Plane {
    private final static int SEAT_NUMBER = 12;
    private final PlaneSeat[] seat;
    private int numEmptySeats;

    public Plane() {
        seat = new PlaneSeat[SEAT_NUMBER];
        for (int i = 0; i < SEAT_NUMBER; i++) {
            seat[i] = new PlaneSeat(i + 1);
        }
        numEmptySeats = SEAT_NUMBER;
    }

    private PlaneSeat[] sortSeats() {
        PlaneSeat[] sortedSeats = new PlaneSeat[SEAT_NUMBER];
        System.arraycopy(seat, 0, sortedSeats, 0, SEAT_NUMBER);
        Arrays.sort(sortedSeats, (o1, o2) -> o1.getCustomerID() - o2.getCustomerID());
        return sortedSeats;
    }

    public void showNumEmptySeats() {
        System.out.println("There are " + numEmptySeats + " empty seats");
    }

    public void showEmptySeats() {
        for (PlaneSeat planeSeat : seat) {
            if (!planeSeat.isOccupied()) {
                System.out.println("SeatID " + planeSeat.getSeatID());
            }
        }
    }

    public void showAssignedSeats(boolean bySeatId) {
        PlaneSeat[] sortedSeats = seat;
        if (!bySeatId) {
            sortedSeats = sortSeats();
        }
        for (PlaneSeat planeSeat : sortedSeats) {
            if (planeSeat.isOccupied()) {
                System.out.println("SeatID " + planeSeat.getSeatID() + " is assigned to CustomerID " + planeSeat.getCustomerID() + ".");
            }
        }
    }

    public void assignSeat(int seatId, int customerId) {
        if (seat[seatId - 1].isOccupied()) {
            System.out.println("Seat already assigned to a customer.");
        } else {
            seat[seatId - 1].assign(customerId);
            numEmptySeats--;
            System.out.println("Seat Assigned!");
        }
    }

    public void unAssignSeat(int seatId) {
        if (!seat[seatId - 1].isOccupied()) {
            System.out.println("Seat " + seatId + " is not occupied.");
        } else {
            seat[seatId - 1].unAssign();
            numEmptySeats++;
            System.out.println("Seat Unassigned!");
        }
    }
}
