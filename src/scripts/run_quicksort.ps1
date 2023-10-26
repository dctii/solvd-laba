# src/scripts/run_quicksort.ps1
# For macOS, for Windows, '/' may need to be changed to backslashes.
# src/scripts/run_quicksort.ps1

# Files to compile and program file to run
$COMPILEE_ARRAY = @("Data.java", "utils/Sort.java", "Main.java")
$PROGRAM = "Main"

# Get the directory of the script
$SCRIPT_DIR = Split-Path -Parent $MyInvocation.MyCommand.Definition
Set-Location -Path $SCRIPT_DIR

# Find 'src' directory
while ((Get-Item (Get-Location)).Name -ne "src")
{
    Set-Location -Path ..
    if ((Get-Location) -eq "/")
    {
        Write-Host -ForegroundColor Red "Reached root directory, 'src' not found."
        exit 1
    }
}

Write-Host -ForegroundColor Green "Found 'src' directory. Attempting clean, compile, and run..."

$null = $SCRIPT_DIR

function Test-Status
{
    param (
        [string]$pass,
        [string]$fail
    )

    if ($LASTEXITCODE -eq 0)
    {
        Write-Host -ForegroundColor Green "• $pass"
    }
    else
    {
        Write-Host -ForegroundColor Red "• $fail (Exit Code: $LASTEXITCODE)"
        exit 1
    }
}

# Pre-cleaning: remove existing .class files
$existingClassFiles = Get-ChildItem -Path . -File -Filter *.class
if ($existingClassFiles.Count -gt 0)
{
    foreach ($classFile in $existingClassFiles)
    {
        Remove-Item -Path $classFile.FullName -Force
        if ($?)
        {
            Write-Host -ForegroundColor Green "• Removed: $( $classFile.Name )"
        }
        else
        {
            Write-Host -ForegroundColor Red "• Failed to remove: $( $classFile.Name )"
        }
    }
    Test-Status -pass "Pre-cleaning process successful." -fail "Pre-cleaning process failed."
}
else
{
    Write-Host -ForegroundColor Green "Pre-cleaning process successful."
}

# Check file existence
$missing_files = @()
foreach ($COMPILEE in $COMPILEE_ARRAY)
{
    if (!(Test-Path -PathType Leaf "$COMPILEE"))
    {
        Write-Host -ForegroundColor Red "• File not found: '$COMPILEE'"
        $missing_files += $COMPILEE
    }
}

# If any files are missing, exit
if ($missing_files.Count -ne 0)
{
    Write-Host -ForegroundColor Red "There are missing files. Exiting..."
    exit 1
}
else
{
    Write-Host -ForegroundColor Green "All compilees present."
}

# If we reach here, all files exist. Proceed with compilation.
foreach ($COMPILEE in $COMPILEE_ARRAY)
{
    javac "$COMPILEE"
    Test-Status -pass "'$COMPILEE' compiled successfully." -fail "'$COMPILEE' compilation failed."
}

Write-Host ""

# Run
java $PROGRAM
Test-Status -pass "'$PROGRAM' ran successfully." -fail "Java program execution failed."

# Post-cleaning: remove existing .class files
$existingClassFiles = Get-ChildItem -Path . -File -Filter *.class
if ($existingClassFiles.Count -gt 0)
{
    foreach ($classFile in $existingClassFiles)
    {
        Remove-Item -Path $classFile.FullName -Force
        if ($?)
        {
            Write-Host -ForegroundColor Green "• Removed: $( $classFile.Name )"
        }
        else
        {
            Write-Host -ForegroundColor Red "• Failed to remove: $( $classFile.Name )"
        }
    }
    Test-Status -pass "Post-cleaning process successful." -fail "Post-cleaning process failed."
}
else
{
    Write-Host -ForegroundColor Green "Post-cleaning process successful."
}
