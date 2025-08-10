# Commonly Used Git Commands

This guide covers the most frequently used Git commands and some tips and tricks to improve your workflow.

---

## **Basic Git Commands**

1. **Initialize a repository**:
   ```bash
   git init
   ```

2. **Clone a repository**:
   ```bash
   git clone <repository-url>
   ```

3. **Check the status of the repository**:
   ```bash
   git status
   ```

4. **Stage changes**:
   ```bash
   git add <file>       # Stage a specific file
   git add .            # Stage all changes in the current directory
   git add --all        # Stage all changes in the repository
   ```

5. **Commit changes**:
   ```bash
   git commit -m "Commit message"
   ```

6. **View commit history**:
   ```bash
   git log
   ```

---

## **Branching and Merging**

7. **Create a new branch**:
   ```bash
   git branch <branch-name>
   ```

8. **Switch to a branch**:
   ```bash
   git checkout <branch-name>
   ```

9. **Create and switch to a new branch**:
   ```bash
   git checkout -b <branch-name>
   ```

10. **Merge a branch into the current branch**:
    ```bash
    git merge <branch-name>
    ```

11. **Delete a branch**:
    ```bash
    git branch -d <branch-name>       # Delete a local branch
    git push origin --delete <branch-name>  # Delete a remote branch
    ```

---

## **Remote Repositories**

12. **Add a remote repository**:
    ```bash
    git remote add origin <repository-url>
    ```

13. **Push changes to a remote repository**:
    ```bash
    git push origin <branch-name>
    ```

14. **Pull changes from a remote repository**:
    ```bash
    git pull origin <branch-name>
    ```

15. **Fetch changes from a remote repository**:
    ```bash
    git fetch origin
    ```

---

## **Undoing Changes**

16. **Unstage changes**:
    ```bash
    git reset <file>
    ```

17. **Discard local changes to a file**:
    ```bash
    git checkout -- <file>
    ```

18. **Revert a commit**:
    ```bash
    git revert <commit-hash>
    ```

19. **Reset to a previous commit**:
    ```bash
    git reset --hard <commit-hash>
    ```

---

## **Miscellaneous**

20. **Show differences between changes**:
    ```bash
    git diff
    ```

21. **Stash changes**:
    ```bash
    git stash
    ```

22. **Apply stashed changes**:
    ```bash
    git stash apply
    ```

23. **List all branches**:
    ```bash
    git branch -a
    ```

24. **Show remote repositories**:
    ```bash
    git remote -v
    ```

---

## **Tips and Tricks**

1. **Use Aliases**:
   Simplify common commands by creating aliases:
   ```bash
   git config --global alias.st status
   git config --global alias.co checkout
   git config --global alias.br branch
   git config --global alias.cm commit
   ```

2. **Amend the Last Commit**:
   Modify the most recent commit (e.g., to fix a message):
   ```bash
   git commit --amend
   ```

3. **View a Graph of Commits**:
   See a visual representation of your branch history:
   ```bash
   git log --oneline --graph --all
   ```

4. **Interactive Rebase**:
   Clean up your commit history before pushing:
   ```bash
   git rebase -i HEAD~<number-of-commits>
   ```

5. **Check What Will Be Pushed**:
   Preview changes that will be pushed to the remote:
   ```bash
   git diff --cached origin/<branch-name>
   ```

6. **Undo the Last Push**:
   If you accidentally push something, you can undo it:
   ```bash
   git reset --soft HEAD~1
   git push --force
   ```

7. **Clean Up Untracked Files**:
   Remove untracked files and directories:
   ```bash
   git clean -fd
   ```

8. **Cherry-Pick a Commit**:
   Apply a specific commit from another branch:
   ```bash
   git cherry-pick <commit-hash>
   ```

---

These commands and tips should cover most of your Git needs and help you work more efficiently!
