package SamsungAlgorithm_SecondHalf_23.Baekjoon.나무재테크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * - 개체
 *  1. 격자
 *      - N * N 크기
 *      - (r, c) 는 (1, 1) 부터 시작한다.
 *      - 가장 처음 양분은 모든 칸에 5씩 들어있다.
 *
 *  2. 나무
 *
 *
 * - 조건
 *  1. 같은 격자 안에 여러 개의 나무가 있을 수 있다.
 *
 * - 진행
 *  1. M 개의 나무를 구매해 땅에 심는다.
 *  2. K 번의 사계절을 보낸다.
 *      2-1. 봄
 *          - 자신의 나이 만큼 양분을 먹고 나이가 1 증가. 각각의 나무는 자기 자신 칸에 있는 양분만 먹는다.
 *          - 한 칸에 여러 나무가 있다면 '나이가 어린' 나무부터 양분을 먹는다.
 *          - 만약, 땅에 양분이 부족해서 자신의 나이만큼 양분을 먹지 못하면 나무는 즉시 죽는다.
 *
 *      2-2. 여름
 *          - 봄에 죽은 나무가 양분으로 변한다.
 *          - 각각 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
 *          - 소수점 아래는 버린다.
 *
 *      2-3. 가을
 *          - 나무가 번식한다.
 *          - 번식하는 나무는 나이가 5의 배수여야 한다.
 *          - 인접한 8개 칸에 나이가 1인 나무가 생긴다.
 *          - 격자를 벗어나면 생기지 않는다.
 *
 *      2-4. 겨울
 *          - 땅에 양분을 추가한다.
 *          - 각 칸에 추가되는 양분의 양은 A[r][c] 이고 입력으로 주어진다.
 *
 * - answer : K 년이 지난 후 살아있는 나무의 개수를 구한다.
 */
public class 나무_제태크_서요셉 {

    static class Tree {
        int x, y;       // 좌표
        int age;        // 나이

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    static int N, M, K, treeCnt;

    static int[][] A;                   // 겨울 마다 추가되는 양분
    static int[][] nutrientBoard;       // 양분 기록

    static List<Tree> deadTree;         // 죽은 나무 리스트
    static List<Tree>[][] treeBoard;    // 나무 위치 및 정보

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1];
        nutrientBoard = new int[N + 1][N + 1];

        deadTree = new ArrayList<>();
        treeBoard = new List[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                treeBoard[i][j] = new ArrayList<>();
            }
        }

        // 겨울 마다 추가되는 양분 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 양분 정보 저장
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nutrientBoard[i][j] = 5;
            }
        }

        // 나무 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());           // 나무 좌표 (x, y)
            int z = Integer.parseInt(st.nextToken());           // 나무 나이

            Tree tree = new Tree(x, y, z);
            treeBoard[x][y].add(tree);
        }

    }
    public static void main(String[] args) throws Exception {
        input();

        // K 번의 사계절을 보낸다.
        for (int i = 0; i < K; i++) {
            // 봄
            spring();

            // 여름
            summer();

            // 가을
            autumn();

            // 겨울
            winter();
        }

        // 살아있는 나무 개수 구하기
        getTreeCnt();
        System.out.println(treeCnt);
    }

    // 2-1. 봄
    // - 자신의 나이 만큼 양분을 먹고 나이가 1 증가. 각각의 나무는 자기 자신 칸에 있는 양분만 먹는다.
    // - 한 칸에 여러 나무가 있다면 '나이가 어린' 나무부터 양분을 먹는다.
    // - 만약, 땅에 양분이 부족해서 자신의 나이만큼 양분을 먹지 못하면 나무는 즉시 죽는다.
    static void spring() {

    }

    // 2-2. 여름
    // - 봄에 죽은 나무가 양분으로 변한다.
    // - 각각 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
    // - 소수점 아래는 버린다.
    static void summer() {

    }

    // 2-3. 가을
    // - 나무가 번식한다.
    // - 번식하는 나무는 나이가 5의 배수여야 한다.
    // - 인접한 8개 칸에 나이가 1인 나무가 생긴다.
    // - 격자를 벗어나면 생기지 않는다.
    static void autumn() {

    }

    // 2-4. 겨울
    // - 땅에 양분을 추가한다.
    // - 각 칸에 추가되는 양분의 양은 A[r][c] 이고 입력으로 주어진다.
    static void winter() {

    }

    // 살아있는 나무 수를 센다.
    static void getTreeCnt() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (treeBoard[i][j].size() > 0) treeCnt += treeBoard[i][j].size();
            }
        }
    }
}
