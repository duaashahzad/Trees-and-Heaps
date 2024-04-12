import java.util.*;

public class Election {

    private Map<String, Integer> candidateVotes;
    private PriorityQueue<Map.Entry<String, Integer>> maxHeap;

    public Election()
    {
        candidateVotes = new HashMap<>();

        //create a priority queue (maxHeap) that orders its elements based on the
        // number of votes each candidate has
        maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); //
    }

    public void initializeCandidates(LinkedList<String> candidates){
        for(String candidate : candidates)
        {
            candidateVotes.put(candidate, 0);
        }
    }

    private void updateHeap() {
        maxHeap.clear();
        maxHeap.addAll(candidateVotes.entrySet());
    }

    public void castVote(String candidate)
    {
        candidateVotes.put(candidate, candidateVotes.getOrDefault(candidate, 0) + 1);
        updateHeap();
    }

    public void castRandomVote()
    {
        Random rand = new Random();
        List<String> candidates = new ArrayList<>(candidateVotes.keySet());
        String randomCandidate = candidates.get(rand.nextInt(candidates.size()));
        castVote(randomCandidate);
    }

    public void rigElection(String candidate) {


        int remainingVotes = maxHeap.size();

        for (String c : candidateVotes.keySet()) {
            candidateVotes.put(c,0);
        }

        for (int i = 0; i < remainingVotes; i++) {
            castVote(candidate);
        }
    }

    public List<String> getTopKCandidates(int k)
    {
        List<String> topCandidates = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> copyHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); // Supplying comparator

        copyHeap.addAll(maxHeap); // Copying elements from maxHeap

        for (int i = 0; i < k && !copyHeap.isEmpty(); i++) {
            topCandidates.add(copyHeap.poll().getKey());
        }

        return topCandidates;
    }

    public void auditElection()
    {
        for(Map.Entry<String, Integer> entry : maxHeap) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
