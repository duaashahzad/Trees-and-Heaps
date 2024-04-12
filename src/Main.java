import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> candidates = new LinkedList<>();
        candidates.add("Marcus Fenix");
        candidates.add("Dominic Santiago");
        candidates.add("Damon Baird");
        candidates.add("Cole Train");
        candidates.add("Anya Stroud");

        ElectionSystem electionSystem = new ElectionSystem();
        electionSystem.initializeElection(candidates);
        int p = 5; // Number of electorate votes to simulate

        // Simulating votes
        electionSystem.simulateVotes(List.of("Cole Train", "Cole Train", "Marcus Fenix", "Anya Stroud", "Anya Stroud"));

        // Getting top candidates after initial votes
        System.out.println("Top 3 candidates after 5 votes: ");
        electionSystem.getTopCandidates(3);

        // Rigging the election
        System.out.println("Rigging the election for Marcus Fenix:");
        electionSystem.rigElection("Marcus Fenix");

        // Getting top candidates after rigging
        System.out.println("Top 3 candidates after rigging the election: ");
        electionSystem.getTopCandidates(3);

        // Auditing the election
        System.out.println("Audit:");
        electionSystem.auditElection();
    }
}