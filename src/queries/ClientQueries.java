package queries;

import java.security.PublicKey;

public class ClientQueries {
    public static final String REGISTER_CLIENT ="INSERT INTO client(name, surname, fin, serialNumber, departures, registerDate, updatedate, memberExpirationdate, amount) "+
            "VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_CLIENT="UPDATE client SET departures=?,updateDate=?,memberExpirationDate=? WHERE fin=? and status=1";
    public static final String INCREASE_DEPARTURE="UPDATE client SET departures=departures-1 WHERE fin=?";
    public static final String FIND_DEPARTURE_BY_FIN="SELECT departures FROM client WHERE fin=?";

    public static final String SHOW_ALL_CLIENT="SELECT * FROM client WHERE status=1";

}
