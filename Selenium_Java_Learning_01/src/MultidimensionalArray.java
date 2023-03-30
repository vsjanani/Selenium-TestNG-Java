import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

class MultidimensionalArray {
	public static void main(String[] args) {

		String[][] a = { { "exptdUrlTitle", "Men’s & Women’s Jeans, Clothes & Accessories | American Eagl" },
				{ "exptdOptFrmWomen", "Tops" }, { "exptdProdName", "AE Go Big Shirt" }

		};
        System.out.println("row length" + a.length);

		String[][] b = new String[3][2];
		int r = -1;

		for (int i = 0; i < a.length; ++i) {
			r++;
			for (int j = 0; j < a[i].length; ++j) {
				System.out.println("column length"+ a[i].length);
//                b[r][0] = a[i][j];
//                b[r][1] = a[i][j];
//                System.out.println(b[i][j]);
			}
		}

//        int[][] c = new int[2][3];
		int[][] c = { { 100, 200, 300 }, { 400, 500, 600 } };

		System.out.println(c.length);
		System.out.println(c[0].length); // prints column length of first row

	}
}
