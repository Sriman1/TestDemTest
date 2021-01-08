
public class FreshPromotion {

	 public static int isWinner(String[][] codeList, String[] shoppingCart) {
		  int i = 0; // i points to group
		    int k = 0; // points to fruit in cart
		    while (i < codeList.length && k < shoppingCart.length) {
		        int j = 0; // j points to fruit in group
		        while (j < codeList[i].length && k < shoppingCart.length) {
		            if (!isMatch(codeList[i][j], shoppingCart[k++])) {
		                break;
		            }
		            j++;
		        }
		        if (j == codeList[i].length) {
		            i++;
		        } else {
		            k -= j;
		        }
		    }

		    return i == codeList.length ? 1 : 0;
	    }
	        
	 private static boolean isMatch(String x, String y) {
		    return "anything".equals(x) || x.equals(y);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][]codeList = {{"apple", "apple"}, {"banana", "anything", "banana"}};
				String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "banana"};
				
				isWinner(codeList, shoppingCart);

	}

}
