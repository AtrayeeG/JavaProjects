import java.util.*;

class SubjectInfo{
    long diff;
    int idx;
    SubjectInfo(long diff, int idx){
        this.diff = diff;
        this.idx = idx;
    }
}


class MaxSubjects {
    public static int maxSubjectsNumber(int[] answered,int[] needed, long q){
        ArrayList<SubjectInfo> diffList = new ArrayList<>();
        for(int i = 0; i < answered.length; i++){
           long diff = Math.max(0, needed[i]- answered[i]);
           diffList.add(new SubjectInfo(diff, i));
        }
        Collections.sort(diffList, (a,b) -> Long.compare(a.diff,b.diff));

        int subjectsPassed = 0;
        for(SubjectInfo subject : diffList){
            if (q >= subject.diff){
                q -=subject.diff;
                subjectsPassed++;
            }else{
                break;
            }
        }
        return subjectsPassed;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long q = sc.nextLong();
        int[] answered = new int[n];
        int[] needed = new int[n];
        for(int i = 0; i< n; i++){
                answered[i] =sc.nextInt();
        }
        for(int i =0; i < n; i ++){
            needed[i] = sc.nextInt();
        }
        System.out.println(maxSubjectsNumber(answered, needed, q));
        sc.close();
    }
    
}
