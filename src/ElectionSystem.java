import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class ElectionSystem {

    private Election election;

    public ElectionSystem() {
        election = new Election();
    }

    public void initializeElection(LinkedList<String> candidates)
    {
        election.initializeCandidates(candidates);
    }

    public void simulateVotes(List<String> votes)
    {
        for(String vote : votes){
            election.castVote(vote);
        }
    }

    public void rigElection(String candidate){
        election.rigElection(candidate);
    }

    public void getTopCandidates(int k){
        List<String> topCandidates = election.getTopKCandidates(k);
        System.out.println("Top " + k + " candidates: " + topCandidates);
    }

    public void auditElection(){
        election.auditElection();
    }
}


