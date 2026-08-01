# Local Save Fixture

`captureReferenceSave` copies the latest validated hybrid career to
`fixtures/local/career-reference` and writes only its hashes to
`save-reference.json`.

The binary save remains local and ignored by Git. Verify it at any time with:

```powershell
.\gradlew.bat verifyReferenceSave
```
