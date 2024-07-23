package dbc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Score {
	public int insertDate() throws ClassNotFoundException, SQLException {
		int result = 0;

		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String hak, name, str;
		int kor, eng, mat, tot, ave;
		Scanner br = new Scanner(System.in);

		try {
			System.out.println("학번?");
			hak = br.next();
			
			br.nextLine();
			System.out.println("이름?");
			name = br.nextLine();

			System.out.println("국어?");
			kor = br.nextInt();

			System.out.println("영어?");
			eng = br.nextInt();

			System.out.println("수학?");
			// mat = Integer.parseInt(br.nextLine());
			mat = br.nextInt();

			String sql = "insert into score (hak, name, kor, eng, mat) values (";
			sql += "'" + hak + "'," + "'" + name + "', ";
			sql += "" + kor + ", " + "" + eng + ", " + "" + mat + ")";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public void selectAll() throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		String sql, hak, name, str;
		int kor, eng, mat, tot, ave;
		Connection conn = DBConn.getConnection();

		try {
//			sql = "select hak, name, kor, eng, mat,";
//			sql += "(kor+eng+mat) as tot,"; // 문자 인덱스 사용을 위해 별칭 필요
//			sql += "(kor+eng+mat)/3 as ave"; // 문자 인덱스 사용을 위해 별칭 필요
//			sql += "from score order by hak";
			sql = "select hak, name, kor, eng, mat,(kor+eng+mat) as tot, (kor+eng+mat)/3 as ave from score order by hak";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				hak = rs.getString("hak");
				name = rs.getString("name");
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				mat = rs.getInt("mat");
				tot = rs.getInt("tot");
				ave = rs.getInt("ave");
				str = String.format("%-10s %-15s %5d %5d %5d %5d %5d", hak, name, kor, eng, mat, tot, ave);
				System.out.println(str);
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectName() throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = DBConn.getConnection();

		String sql, str, searchName, hak, name;
		int kor, eng, mat, tot, ave;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("검색할 이름?");
			searchName = br.readLine();

			sql = "select hak, name, kor, eng, mat, (kor+eng+mat) as tot, (kor+eng+mat)/3 as ave from score where upper(name) like upper('" + searchName + "%')";
//			select hak, name, kor, eng, mat, (kor+eng+mat) as tot, (kor+eng+mat)/3 as ave from score where upper(name) like upper('searchName%');

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				hak = rs.getString("hak");
				name = rs.getString("name");
				kor = rs.getInt("kor");
				eng = rs.getInt("eng");
				mat = rs.getInt("mat");
				tot = rs.getInt("tot");
				ave = rs.getInt("ave");

				str = String.format("%-10s %-15s %5d %5d %5d %5d %5d", hak, name, kor, eng, mat, tot, ave); // %-10s : 10칸, 좌측정렬을 의미. %-15s : 15칸, 좌측정렬을 의미.
				System.out.println(str);
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int deleteDate() throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;
		String sql, str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("삭제할 학번?");
			str = br.readLine();
			sql = "delete from score where hak = '" + str + "'";

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int updateData() throws ClassNotFoundException, SQLException {
		int result = 0;
		Connection conn = DBConn.getConnection();
		Statement stmt = null;

		String sql, hak, name;
		int kor, eng, mat;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.in --> Steam 방식을 반환(바이트 방식) -> InputStream으로 변환해 문자방식으로 변환. 
		// BufferedReader : Buffer를 통해 더 빠르게 출력되는 것처럼 느껴지는 문자방식으로 변환

		try {
			System.out.println("수정할 학번?");
			hak = br.readLine(); // readLine() : 공백도 포함해서 받을 수 있음 (문자열로만 받을 수 있음)

			System.out.println("이름?");
			name = br.readLine();

			System.out.println("국어?");
			kor = Integer.parseInt(br.readLine()); // readLine은 문자열로 반환되기 때문에 정수형으로 형 변환

			System.out.println("영어?");
			eng = Integer.parseInt(br.readLine());

			System.out.println("수학?");
			mat = Integer.parseInt(br.readLine());

			sql = "update score set";
			sql += "name= '" + name + "', kor = " + kor + ",";
			sql += "eng = " + eng + ", mat = " + mat + "";
			sql += "where hak ='" + hak + "'";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			stmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
