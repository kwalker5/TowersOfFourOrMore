//Kate Walker
import java.util.*;

public class TowersOfFourOrMore {

    int[][] Board;//itialize the Board for the board
    int rows;//int to store the rows
    int cols;//int to store the columns
    int filled;//int to signified filled

    public TowersOfFourOrMore(int ballsintube, int numtubes, int fill){//constructor to intialize the data
        Board=new int[ballsintube][numtubes];//set the Board size to the balls in the tube by the number of tubes
        rows=ballsintube;//set rows to balls in tube
        cols=numtubes;//set columns to the number of tubes
        filled=fill;//set filled to fill
    }

    public void solve(){//function to solve the puzzle
        int oneCount=0;//set the int oneCount to 0
        int zeroCount=0;//set the int zeroCount to 0
        int gameCheck=0;//set gameCheck to 0
        int count=0;//set count to 0
        System.out.println("Moves:");

        while(count<filled-1) {//loop to loop until all columns are filled with either one or zero
            int z = count + 2;//set int z to the count + 2
            for (int i = count; i < z; i++) {//for loop to loop from the count to the value of z
                for (int j = 0; j < rows; j++) {//for loop to loop from 0 to the number of rows
                    int m = Board[rows - j - 1][cols - gameCheck - 1];//set int m to the Board at the rows - j and cols - gameCheck -1
                    if (Board[j][i] == 0)//if the Board at j and i is 0
                        zeroCount++;//increment 0 count
                    else if (Board[j][i] == 1)//if the Board at j and i is 1
                        oneCount++;//increment the 1 count
                    Board[rows - j - 1][cols - gameCheck - 1] = Board[j][i];//set Board at rows-j-1 and cols-gameCheck-1 to the Board at j and i
                    System.out.println(" t"+i+" - t"+(cols-gameCheck-1));//print the move
                    Board[j][i] = m;//set Board at j and i to the value of m
                }
                gameCheck++;//increment gameCheck
            }
            gameCheck = 0;//set gameCheck to 0
            int index = count;//set int index to the count

            if (zeroCount >= oneCount) {//if the zero count is greater than or equal to the one count
                int x = 0;//intialize x to 0
                int y = 0;//intialize y to 0
                for (int k = cols - 2; k < cols; k++) {//loop from cols-2 to cols
                    for (int l = 0; l < rows; l++) {//loop from 0 to rows
                        if (!checkCol(index)) {//if the column doesn't match
                            if (Board[l][k] == 0) {//if Board at l and k is 0
                                Board[rows - x - 1][index] = Board[l][k];//set Board at rows-x-1 and index to Board at l and k
                                System.out.println(" t"+k+" - t"+(index));//print the move made
                                x++;//increment x
                                Board[l][k] = -1;//set Board at l and k to -1
                            }
                            else {//if not equal to 0
                                Board[rows - y - 1][index + 1] = Board[l][k];//set Board at rows-y-1 and index +1 to Board at l and k
                                System.out.println(" t"+k+" - t"+(index+1));//print thr move made
                                y++;//increment y
                                Board[l][k] = -1;//set Board at l and k to -1
                            }
                        }
                        else {//if the column does match
                            Board[rows - y - 1][index + 1] = Board[l][k];//set Board at rows-y-1 and index +1 to Board at l and k
                            System.out.println(" t"+k+" - t"+(index+1));//print the move made
                            y++;//increment y
                            Board[l][k] = -1;//set Board at l and k to -1
                        }
                    }
                }
            }
            else if (zeroCount < oneCount) {//if zeroCount is less than oneCount

                int x = 0;//intialize x to 0
                int y = 0;//intialize y to 0
                for (int k = cols - 2; k < cols; k++) {//loop from cols-2 to cols
                    for (int l = 0; l < rows; l++) {//loop from 0 to rows
                        if (!checkCol(index)) {//if the column doesn't match
                            if (Board[l][k] == 1) {//if Board at l and k is 1
                                Board[rows - x - 1][index] = Board[l][k];//set Board at rows-x-1 and index to Board at l and k
                                System.out.println(" t"+k+" - t"+(index));//print the move made
                                x++;//increment x
                                Board[l][k] = -1;//set Board at l and k to -1
                            }
                            else {//if not equal to 1
                                Board[rows - y - 1][index + 1] = Board[l][k];//set Board at rows-y-1 and index +1 to Board at l and k
                                System.out.println(" t"+k+" - t"+(index+1));//print thr move made
                                y++;//increment y
                                Board[l][k] = -1;//set Board at l and k to -1
                            }
                        }
                        else {//if the column does match
                            Board[rows - y - 1][index + 1] = Board[l][k];//set Board at rows-y-1 and index +1 to Board at l and k
                            System.out.println(" t" + k + " - t" + (index + 1));//print the move made
                            y++;//increment y
                            Board[l][k] = -1;//set Board at l and k to -1
                        }
                    }
                }
            }
            count++;//increment the count
            zeroCount=0;//set zeroCount to 0
            oneCount=0;//set oneCount to 0
        }
        System.out.println();//print an empty line
    }

    public boolean checkCol(int column){//function to check if the whole column is matching or not and is not -1
        int tempVal=Board[0][column];//set the tempVal to the Board at 0 and the column
        boolean flag=true;//set flag to true
        for(int i=0;i<rows;i++){//loop through the rows
            if(Board[i][column]==tempVal && tempVal!=-1){//if the Board at i and column is equal to the tempVal and tempVal is not equal to -1
                continue;//continue
            }
            else{//if the Board at i and the column isn't equal to the tempVal and the tempVal is -1
                flag=false;//set flag to false
                break;//and break
            }
        }
        return flag;//return the flag
    }
   
    public void fill(){//function to generate a random order of ones and zeros to put in the 2D array
        for(int i=0;i<rows;i++){//loop through the rows
            for(int j=0;j<cols;j++){//loop through the columns
                Board[i][j]=-1;//set Board at i and j to -1 to start
            }
        }
        ArrayList<Integer> tempList=new ArrayList<>(filled*rows);//make a templist and make it the size of the filled times the rows
        int x=0;//intialize int x to be 0
        for(int i=0;i<filled;i++){//loop from 0 to filled
            for(int j=0;j<rows;j++){//loop from 0 to rows
                tempList.add(x);//add x to the templist
            }
            if(x==0)//if x is 0
                x++;//increment x
            else//if x is not 0
                x--;//decrement x
        }
        int k=0;//intialize k to 0
        while(!(tempList.isEmpty())){//while the tempList is empty
            for(int j=0;j<filled;j++){//loop from 0 to filled
                int ran=new Random().nextInt(tempList.size());//set int ran to a random int for the size of the list
                Board[k][j]=tempList.get(ran);//set Board at k and j to tempList.get ran
                tempList.remove(ran);//remove used ran from the temp list
            }
            k++;//increment k
        }
    }

    public void print(){//function to print the Board
        System.out.println("------------");
        for(int i=0;i<rows;i++){//loop through rows
            for(int j=0;j<cols;j++){//loop through columns
                if(Board[i][j] != -1) {
                    System.out.print(Board[i][j] + " ");//print the Board at i and j and then a space
                }
            }
            System.out.println();//print a blank line
        }
        System.out.println("------------");
        for(int k=0; k<cols; k++){
            if(Board[1][k] != -1) {
                System.out.print(k +1 + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int numTubes=0;//set the number of tubes to 0
        int ballsIntube=0;//set the balls in the tubes to 0
        int filled=0;//set filled to 0 to represent the number of tubes filled

        if(args.length<3){
            System.out.println("3 inputs needed, exiting program");
            System.exit(1);
        }
        numTubes =Integer.parseInt(args[0]);//Integer.parseInt(arr[0]);
        ballsIntube = Integer.parseInt(args[1]);
        filled = Integer.parseInt(args[2]);
        while(numTubes<4||numTubes>12){
            System.out.println(numTubes+" number of tubes is not valid. Enter a value between 4 and 12:");
            numTubes=sc.nextInt();
        }
        while(ballsIntube<4||ballsIntube>8){
            System.out.println(ballsIntube+" number of balls per tube is not valid. Enter a value between 4 and 8:");
            ballsIntube=sc.nextInt();
        }
        while(filled<2||filled>numTubes-2){
            System.out.println(filled+" number of tubes filled is not valid. Enter a value between 2 and " + numTubes + " minus 2:");
            filled=sc.nextInt();
        }

        TowersOfFourOrMore tower=new TowersOfFourOrMore(ballsIntube,numTubes,filled);
        tower.fill();
        System.out.println("Random Board:");
        tower.print();
        System.out.println();
        tower.solve();
        System.out.println("Solved Board: ");
        tower.print();
    }
}