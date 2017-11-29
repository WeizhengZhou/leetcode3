package gogo;

public class RetangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int w=find(A,C,E,G);
    	int h=find(B,D,F,H);
        if (w*h==(C-A)*(D-B)) return (G-E)*(H-F);
    	if (w*h==(G-E)*(H-F)) return (C-A)*(D-B);
    	return (C-A)*(D-B)+(G-E)*(H-F)-w*h;
    }
    private int find(int A, int B, int C, int D){
        if (A==B) return 0;
        if (C==D) return 0;
    	if (A<C) {
    		if (B<=C) return 0;
    		return Math.min(B, D)-C;
    	} else if (A>C) {
    		if (D<=A) return 0;
    		return Math.min(B, D)-A;
    	} else {
    		return Math.min(B, D)-A;
    	}
    }
}
