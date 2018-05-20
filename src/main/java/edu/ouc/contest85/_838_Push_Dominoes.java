package edu.ouc.contest85;

public class _838_Push_Dominoes {

    public String pushDominoes(String dominoes) {

        Domino[] dominoArr = new Domino[dominoes.length() + 2];
        int len = 0;
        Domino head = new Domino(-1, 'L');
        dominoArr[len++] = head;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) != '.') {
                Domino d = new Domino(i, dominoes.charAt(i));
                dominoArr[len++] = d;
            }
        }
        Domino tail = new Domino(dominoes.length(), 'R');
        dominoArr[len++] = tail;

        char[] result = dominoes.toCharArray();
        for (int index = 0; index < len - 1; ++index) {
            int posX = dominoArr[index].pos;
            int posY = dominoArr[index + 1].pos;
            char stateX = dominoArr[index].state;
            char stateY = dominoArr[index + 1].state;

            if (stateX == stateY) {
                for (int k = posX + 1; k < posY; ++k) {
                    result[k] = stateX;
                }
            } else if (stateX > stateY) { // RL
                for (int k = posX + 1; k < posY; ++k) {
                    result[k] = k - posX == posY - k ? '.' : k - posX < posY - k ? 'R' : 'L';
                }
            }
        }
        return new String(result);
    }

    class Domino {
        int pos;
        char state;

        public Domino(int pos, char state) {
            this.pos = pos;
            this.state = state;
        }
    }

    public static void main(String args[]) {
        //test case1
        _838_Push_Dominoes
                tester = new _838_Push_Dominoes();

        String S = ".L.R...LR..L..";
        System.out.println(tester.pushDominoes(S));
    }
}
