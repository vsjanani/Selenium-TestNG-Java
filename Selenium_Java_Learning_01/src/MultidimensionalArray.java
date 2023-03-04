import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

class MultidimensionalArray {
    public static void main(String[] args) {

        String[][] a = {
            {"exptdUrlTitle","Men’s & Women’s Jeans, Clothes & Accessories | American Eagl"}, 
            {"exptdOptFrmWomen","Tops"}, 
            {"exptdProdName","AE Go Big Shirt"}
            
        };
//        System.out.println(a.length);
        
        String[][] b = new String[3][2];
        int r=-1;
        
      
        for (int i = 0; i < a.length; ++i) {
        	r++;
            for(int j = 0; j < a[i].length; ++j) {
//            	System.out.println(a[i].length);
                b[r][0] = a[i][j];
                b[r][1] = a[i][j];
                System.out.println(b[i][j]);
            }
        }
    }
} 

