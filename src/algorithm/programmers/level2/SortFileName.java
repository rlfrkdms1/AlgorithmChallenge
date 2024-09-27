import java.util.*;

class SortFileName {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        int index = 0;
        for(String file : files) {
            boolean first = true;
            boolean second = false;
            int index1 = 0;
            int index2 = 0;
            for(int i = 0; i < file.length(); i++) {
                if(first && Character.isDigit(file.charAt(i))) {
                    first = false;
                    index1 = i;
                    second = true;
                }
                if(second && !Character.isDigit(file.charAt(i))) {
                    index2 = i;
                    break;
                }
            }
            if(index2 - index1 > 5) {
                index2 = index1+5;
            } 
            if(index2 == 0) index2 = file.length();
            String head = file.substring(0, index1);
            int number = Integer.parseInt(file.substring(index1, index2));
            
            String tail = file.substring(index2, file.length());
            fileList.add(new File(index, head, number, tail));
            index++;
        }
        
        
        
         Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                int differ = f1.head.compareToIgnoreCase(f2.head);
                if(differ == 0) {
                    return f1.number - f2.number;
                } else return differ;
            }
        });
    
        
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++) {
            answer[i] = files[fileList.get(i).index];
        }
        return answer;
    }
    
    static class File {
        String head;
        int number;
        String tail;
        int index;
        
        public File(int index, String head, int number, String tail) {
            this.index = index;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
}
