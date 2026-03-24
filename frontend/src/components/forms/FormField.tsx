import React from 'react';

interface FormFieldProps extends React.InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  error?: string;
  helperText?: string;
}

export const FormField = ({ label, error, helperText, ...props }: FormFieldProps) => {
  return (
    <div className="w-full max-w-xs p-2 shadow-md">
      {label && (
        <label className="block mb-2"> {label} </label>
      )}

      <input {...props}
        className={`w-full border rounded-lg p-2 focus:ring-2 transition-all duration-300 ease-in-out outline-none
            ${error ? 'border-red-400 focus:ring-red-500' : 'border-gray-400 focus:ring-green-500'}
        `}
      />

      {error && (
        <span className="text-red-500"> {error} </span>
      )}

      {helperText && !error &&(
        <span className="text-gray-500"> {helperText} </span>
      )}
    </div>
  );
};