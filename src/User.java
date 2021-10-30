public class User {
    String name;
    String id;
    String roomNumber;
    String datein, dateout;

    public User(String name, String id, String roomNumber, String datein, String dateout) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
        this.datein = datein;
        this.dateout = dateout;
    }

    public User(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", datein=" + datein +
                ", dateout=" + dateout +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDatein() {
        return datein;
    }

    public void setDatein(String datein) {
        this.datein = datein;
    }

    public String getDateout() {
        return dateout;
    }

    public void setDateout(String dateout) {
        this.dateout = dateout;
    }
}
