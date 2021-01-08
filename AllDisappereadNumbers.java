import java.util.ArrayList;
import java.util.List;

public class AllDisappereadNumbers {
public static List<Integer> findDisappearedNumbers(int[] nums) {
        
        
        List<Integer> list=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
if(nums[Math.abs(nums[i])-1]>0){
    
    nums[Math.abs(nums[i])-1]=-1*nums[Math.abs(nums[i])-1];
}
            else{
                continue;
            }
            
        }
        
        for(int i:nums){
            
            if(i>0){
                list.add(i+1);
            }
        }
        
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[] {4,3,2,7,8,2,3,1};
		findDisappearedNumbers(num);

	}

}
