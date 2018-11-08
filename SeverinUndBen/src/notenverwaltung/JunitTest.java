package notenverwaltung;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class JunitTest {

	@Test
	void test() {
		SqlManager manager = new SqlManager();
		Connection conn = manager.InitConnection();
	}

}
